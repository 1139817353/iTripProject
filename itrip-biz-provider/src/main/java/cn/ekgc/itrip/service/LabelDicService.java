package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.entity.LabelDic;
import org.aspectj.apache.bcel.ExceptionConstants;

import java.awt.*;
import java.util.List;

/**
 * <b>爱旅行-系统字典信息业务层接口</b>
 */
public interface LabelDicService {
	/**
	 * <b>根据查询获得信息列表</b>
	 */
	List<LabelDic> getListByQuery(LabelDic query) throws Exception;
}
