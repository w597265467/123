select phone,name,process
from (select * from (select phone, name,"1.授信-实名" process from user where fin_apply_schedule = 1 and create_time > @since union all
select phone, name,"2.授信-绑卡" from user where fin_apply_schedule = 2 and create_time > @since union all
select phone, name,"3.授信-实人" from user where fin_apply_schedule = 3 and create_time > @since union all
select phone, name,"4.授信-个人资料" from user where fin_apply_schedule = 4 and create_time > @since union all
select phone, name,"5.授信人脸识别失败" from user where fin_apply_fail_code = 30 and create_time > @since union all
select phone, name,"6.授信申请校验失败" from user where fin_apply_fail_code = 31 and create_time > @since union all
select phone, name,"7.授信申请提交失败" from user where fin_apply_fail_code = 32 and create_time > @since union all
select phone, name,"8.授信申请未通过" from user where fin_apply_fail_code = 33 and create_time > @since union all
select phone, name,"9.支用额度不足" from user where fin_apply_fail_code = 34 and create_time > @since union all
select phone, name,"10.支用申请失败" from user where fin_apply_fail_code = 35 and create_time > @since
) a order by a.process desc) b group by phone order by b.process 