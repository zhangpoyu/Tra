package com.unrule;

import javax.persistence.*;

/**
 * 会员
 *
 * @author 刘冬 博客出处：http://www.cnblogs.com/GoodHelper/
 *
 */
@Entity
@Table(name = "t_car")
public class Owner {


	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "id", length = 36)
	public String id;


	/**
	 * 姓名
	 */
	@Column(name = "`name`", length = 45)
	public String name;

	@Column(name = "`number`", length = 18)
	public String number;

	@Column(name = "`id_card`", length = 45)
	public String id_card;

	@Column(name = "email", length = 45)
	public String email;

	@Column(name = "`car_number`", length = 45)
	public String car_number;

	@Column(name = "`car_sign`", length = 45)
	public String  car_sign;

	@Column(name = "`car_style`", length = 45)
	public String car_style;
}
