package cn.ekgc.itrip.service.impl;

import cn.ekgc.itrip.dao.HotelDao;
import cn.ekgc.itrip.pojo.entity.Hotel;
import cn.ekgc.itrip.pojo.vo.HotelVO;
import cn.ekgc.itrip.pojo.vo.SearchHotCityVO;
import cn.ekgc.itrip.service.HotelService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>爱旅行-酒店模块业务层接口实现类</b>
 */
@Service("hotelService")
@Transactional
public class HotelServiceimpl implements HotelService {
	@Autowired
	private SolrClient solrClient;
	@Autowired
	private HotelDao hotelDao;

	/**
	 * <b>根据热门城市查询酒店</b>
	 *
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	public List<HotelVO> searchItripHotelListByHotCity(SearchHotCityVO queryVO) throws Exception {
		//对于Spring Boot注入SolrClient就是HttpSolrClient对象，进行强制类型转换
		HttpSolrClient httpSolrClient = (HttpSolrClient) solrClient;
		httpSolrClient.setParser(new XMLResponseParser());
		//创建Solr的查询参数
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery("cityId:" + queryVO.getCityId());
		solrQuery.setRows(queryVO.getCount());
		// 使用SolrClient进行查询，QueryResponse
		QueryResponse queryResponse = solrClient.query(solrQuery);
		//通过使用QueryResponse提取结果
		return queryResponse.getBeans(HotelVO.class);
	}

	/**
	 * <b>根据主键查询对象信息</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	public Hotel getHotelById(Long hotelId) throws Exception {
		//创建查询对象
		Hotel query = new Hotel();
		query.setId(hotelId);
		//进行列表查询
		List<Hotel> hotelList = hotelDao.findListByQuery(query);

		if (hotelList != null && hotelList.size() > 0){
			return hotelList.get(0);
		}
		return new Hotel();
	}
}