set @since  = ("2018-05-10 00:00:00") ;

select @since; 


select 
	max(case h.a when "进入四合一" then h.b end ) 进入四合一,
    max(case h.a when "下单" then h.b end ) 下单,
    max(case h.a when "身份证上传页面" then h.b end ) 身份证上传页面,
    max(case h.a when "进行了实名认证" then h.b end ) 进行了实名认证,
    max(case h.a when "绑卡页面" then h.b end ) 绑卡页面,
    max(case h.a when "做了绑卡" then h.b end ) 做了绑卡,
    max(case h.a when "人脸识别页面" then h.b end ) 人脸识别页面,
    max(case h.a when "人脸识别获取随机数" then h.b end ) 人脸识别获取随机数,
    max(case h.a when "人脸识别上传了视频" then h.b end ) 人脸识别上传了视频,
    max(case h.a when "个人信息页面" then h.b end ) 个人信息页面,
    max(case h.a when "提交了个人信息" then h.b end) 提交了个人信息
 from (
select 
 g.进入四合一 a,g.计数 b

 from (-- 查询进入到四合一
select "进入四合一", count(id) 计数 from (select id from action_detail where action = "/cfin/trade/start"  and req_time > @since   group by ip) a union all

-- 查询四合一下单
select "下单", count(id)  from (select id from action_detail where action = "/cfin/trade/place/order"  and req_time > @since   group by mobile) b union all 

-- 进入身份证上传页面
select "身份证上传页面",count(id)   from (select id from action_detail where action = "授信-实名"  and req_time > @since   group by mobile) c union all

-- 进入 绑卡页面
select "绑卡页面",count(id)   from (select id from action_detail where action = "授信-绑卡"  and req_time > @since   group by mobile) c union all

-- 进入 人脸识别页面
select "人脸识别页面",count(id)   from (select id from action_detail where action = "授信-实人"  and req_time > @since   group by mobile) c union all

-- 进入 个人信息页面
select "个人信息页面",count(id)   from (select id from action_detail where action = "授信-关联亲属"  and req_time > @since   group by mobile) c union all

-- 进行了实名认证 
select "进行了实名认证",count(id)   from (select id from action_detail where action = "/cfin/credit/realname/verify"  and req_time > @since   group by mobile) c union all
 
-- 做了绑卡  /cfin/credit/bankcard/verify
select "做了绑卡",count(id)  from (select id from action_detail where action = "/cfin/credit/bankcard/verify"  and req_time > @since   group by mobile) d union all

-- 人脸识别获取随机数 /cfin/credit/face/bizno
select "人脸识别获取随机数", count(id)  from (select id from action_detail where action = "/cfin/credit/face/bizno"  and req_time > @since   group by mobile) e union all

-- 人脸识别上传了视频 /cfin/credit/face/upload
select "人脸识别上传了视频",count(id)  from (select id from action_detail where action = "/cfin/credit/face/upload"  and req_time > @since   group by mobile) f union all

-- 提交了个人信息 /cfin/credit/family/verify 
select "提交了个人信息",count(id)  from (select id from action_detail where action = "/cfin/credit/family/verify"  and req_time > @since   group by mobile) h
) g) h