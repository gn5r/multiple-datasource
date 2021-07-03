package com.github.gn5r.multiple.datasource.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.jdbc.entity.NamingType;

/**
 * テストテーブルエンティティ
 *
 * @author gn5r
 */
@Entity(listener = TestListener.class, naming = NamingType.SNAKE_LOWER_CASE)
@Table(name = "test")
public class Test {

    /** ID */
    @Id
    protected Integer id;

    /** テキスト */
    protected String text;

    /** 
     * IDを取得する
     * 
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /** 
     * IDを設定する
     * 
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 
     * テキストを取得する
     * 
     * @return テキスト
     */
    public String getText() {
        return text;
    }

    /** 
     * テキストを設定する
     * 
     * @param text テキスト
     */
    public void setText(String text) {
        this.text = text;
    }
}