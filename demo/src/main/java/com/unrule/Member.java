package com.unrule;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 会员
 *
 * @author 刘冬 博客出处：http://www.cnblogs.com/GoodHelper/
 *
 */
@Entity
@Table(name = "t_unrule")
public class Member{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", length = 36)
	public String id;


	/**
	 * 姓名
	 */
	@Column(name = "`name`", length = 50)
	public String name;

	@Column(name = "`number`", length = 50)
	public String number;

	@Column(name = "`car_number`", length = 50)
	public String car_number;

	@Column(name = "unrule_record", length = 50)
	public String unrule_record;

	@Column(name = "`unrule_reason`", length = 50)
	public String unrule_reason;
}
