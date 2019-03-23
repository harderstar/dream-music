package com.simdy.cms.mapper;

import com.simdy.cms.entity.base.LabelAddEnt;
import com.simdy.cms.entity.base.LabelListEnt;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface LabelMapper {

    @Select("select * from label ")
    public List<LabelListEnt> queryLabels();

    @Select("select id,name,is_cash as isCash,is_tip as isTip,cash_num as cashNum from label where id =#{id}")
    public LabelAddEnt queryLabelById(Integer id);

    @Insert("insert into label (name,is_cash,is_tip,cash_num) value(#{name},#{isCash},#{isTip},#{cashNum})")
    public Integer insertLabel(LabelAddEnt labelAddEnt);

    @Update("update label set name=#{name},is_cash=#{isCash},is_tip=#{isTip},cash_num=#{cashNum} where id =#{id}")
    public Integer updateLabel(LabelAddEnt labelAddEnt);

    @Delete("delete from label where id=#{id}")
    public Integer deleteLabelById(Integer id);
}
