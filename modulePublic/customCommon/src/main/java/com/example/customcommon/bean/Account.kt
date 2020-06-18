package com.example.customcommon.bean

import io.realm.RealmModel
import io.realm.annotations.Ignore
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
//import com.vicpin.krealmextensions.query

@RealmClass
open class UserInfo(//要open
    var privateKeyStr: String? = null,//用户私钥
    var publicKey: String? = null,//用户公钥
    var session: String? = null,//
//    var randomB: String? = null,//
//    @Ignore
//    var publicKeyUrl: String? = null,//没用到
//    var superId: String? = null,//
    @PrimaryKey
    var userId: String? = null,//用户id

    @Ignore
    var mailList: ArrayList<EmailInfo> = ArrayList()//用户邮件列表
) : RealmModel {
    //根据用户公钥查询邮件列表
    fun queryMailList(publicKey: String): ArrayList<EmailInfo> {
        //创建EmailInfo类的实例并调用其query方法
        //这种调用函数的写法的条件是函数最后一个参数是函数且其他参数有默认值或者就没有其他参数
//        EmailInfo().query {
//            equalTo("publicKey", publicKey)
//        }.forEach {
//            mailList.add(it)
//        }
        return mailList
    }
}
/**
 * 个人账号信息对应的邮件信息
 */
@RealmClass
open class EmailInfo(
    @PrimaryKey
    var userId: String? = null,//用户id
    var id: Int? = 0,//编号
    var sex: String? = null,//性别
    var emailAddress: String? = null,//邮件地址
    @Ignore
//    var timeVo: EmailTimeVo? = null,//时间
    var name: String? = null,//名称
    var profession: String? = null,//职业
    var headUrl: String? = null,//头像
    var company: String? = null,//公司组织
    var companyId: Int? = -1,//组织id
    var nickname: String? = null,//昵称
    var roleType: String? = null,//角色类型
    var publicKey: String? = null,//公钥
    var phone: String? = null,//联系电话
    var isCompany: Boolean = false//是否企业帐号

) : RealmModel {
}