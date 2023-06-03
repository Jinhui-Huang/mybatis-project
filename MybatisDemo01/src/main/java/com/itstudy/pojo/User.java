package com.itstudy.pojo;

public class User {
    private Integer customer_id;
    private String first_name;
    private String last_name;
    private String birth_date;
    private String phone;


    public User() {
    }

    public User(Integer customer_id, String first_name, String last_name, String birth_date, String phone) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.phone = phone;
    }

    /**
     * 获取
     * @return customer_id
     */
    public Integer getCustomer_id() {
        return customer_id;
    }

    /**
     * 设置
     * @param customer_id
     */
    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    /**
     * 获取
     * @return first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * 设置
     * @param first_name
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * 获取
     * @return last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * 设置
     * @param last_name
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * 获取
     * @return birth_date
     */
    public String getBirth_date() {
        return birth_date;
    }

    /**
     * 设置
     * @param birth_date
     */
    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    /**
     * 获取
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "customer_id=" + customer_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", birth_date='" + birth_date + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
