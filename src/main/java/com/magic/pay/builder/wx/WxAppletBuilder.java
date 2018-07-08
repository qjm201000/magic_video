package com.magic.pay.builder.wx;

import java.math.BigDecimal;

import com.magic.pay.builder.WxRequestBuilder;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 小程序支付
 * https://pay.weixin.qq.com/wiki/doc/api/wxa/wxa_api.php?chapter=9_1
 */
public class WxAppletBuilder extends WxRequestBuilder{
	private BizContent bizContent = new BizContent();

	@Override
	public Object getBizContent() {
		return bizContent;
	}
	
	@XStreamAlias("xml")
	public static class BizContent{
		// 公众账号ID:微信支付分配的公众账号ID（企业号corpid即为此appId）
		// 必选
		@XStreamAlias("appid")
        private String appId;
        
        // 商户号:微信支付分配的商户号
 		// 必选
		@XStreamAlias("mch_id")
        private String mchId;
        
        // 设备号:自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB"
 		// 非必选
		@XStreamAlias("device_info")
        private String deviceInfo;
        
        // 随机字符串:随机字符串，长度要求在32位以内。推荐随机数生成算法
 		// 必选
        @XStreamAlias("nonce_str")
        private String nonceStr;
        
        // 签名:通过签名算法计算得出的签名值
 		// 必选
        @XStreamAlias("sign")
        private String sign;
        
        // 签名类型:签名类型，默认为MD5，支持HMAC-SHA256和MD5。
 		// 非必选
        @XStreamAlias("sign_type")
        private String signType;
        
        // 商品描述:微商品简单描述
 		// 必选
        @XStreamAlias("body")
        private String body;
        
        // 商品详情:商品详细描述，对于使用单品优惠的商户，改字段必须按照规范上传
 		// 非必选
        @XStreamAlias("detail")
        private String detail;
        
        // 附加数据:附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用
 		// 非必选
        @XStreamAlias("attach")
        private String attach;
        
        // 商户订单号:商户系统内部订单号
 		// 必选
        @XStreamAlias("out_trade_no")
        private String outTradeNo;
        
        // 标价币种:符合ISO 4217标准的三位字母代码，默认人民币：CNY
 		// 非必选
        @XStreamAlias("fee_type")
        private String feeType;
        
        // 标价金额:订单总金额，单位为分
 		// 必选
        @XStreamAlias("total_fee")
        private BigDecimal totalFee;
        
        // 终端IP:APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP
 		// 必选
        @XStreamAlias("spbill_create_ip")
        private String spbillCreateIp;
        
        // 交易起始时间:订单生成时间，格式为yyyyMMddHHmmss
 		// 非必选
        @XStreamAlias("time_start")
        private String timeStart;
        
        // 交易结束时间:订单失效时间，格式为yyyyMMddHHmmss
 		// 非必选
        @XStreamAlias("time_expire")
        private String timeExpire;
        
        // 订单优惠标记:订单优惠标记，使用代金券或立减优惠功能时需要的参数
 		// 非必选
        @XStreamAlias("goods_tag")
        private String goodsTag;
        
        // 通知地址:异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数
 		// 必选
        @XStreamAlias("notify_url")
        private String notifyUrl;
        
        // 交易类型:JSAPI 公众号支付、NATIVE 扫码支付、APP APP支付、MWEB H5支付的交易类型
 		// 必选
        @XStreamAlias("trade_type")
        private String tradeType;
        
        // 商品ID:trade_type=NATIVE时（即扫码支付），此参数必传。此参数为二维码中包含的商品ID，商户自行定义
 		// 非必选
        @XStreamAlias("product_id")
        private String productId;
        
        // 指定支付方式:上传此参数no_credit--可限制用户不能使用信用卡支付
 		// 非必选
        @XStreamAlias("limit_pay")
        private String limitPay;
        
        // 用户标识:trade_type=JSAPI时，此参数必传，此参数为微信用户在商户对应appid下的唯一标识
 		// 必选
        @XStreamAlias("openid")
        private String  openId;
        
    }
	
	/**
     * 签名需要的参数
     * 非空参数值的参数按照参数名ASCII码从小到大排序（字典序）
     * @return
     */
	@Override
    public String toSignString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("appid=").append(bizContent.appId);
        sb.append("&body=").append(bizContent.body);
        sb.append("&mch_id=").append(bizContent.mchId);
        sb.append("&nonce_str=").append(bizContent.nonceStr);
        sb.append("&notify_url=").append(bizContent.notifyUrl);
        sb.append("&openid=").append(bizContent.openId);
        sb.append("&out_trade_no=").append(bizContent.outTradeNo);
        sb.append("&spbill_create_ip=").append(bizContent.spbillCreateIp);
        sb.append("&time_expire=").append(bizContent.timeExpire);
        sb.append("&time_start=").append(bizContent.timeStart);
        sb.append("&total_fee=").append(bizContent.totalFee);
        sb.append("&trade_type=").append(bizContent.tradeType);
        return sb.toString();
    }
	
	public String getAppId() {
		return bizContent.appId;
	}

	public WxAppletBuilder setAppId(String appId) {
		bizContent.appId = appId;
		return this;
	}

	public String getMchId() {
		return bizContent.mchId;
	}


	public WxAppletBuilder setMchId(String mchId) {
		bizContent.mchId = mchId;
		return this;
	}


	public String getDeviceInfo() {
		return bizContent.deviceInfo;
	}


	public WxAppletBuilder setDeviceInfo(String deviceInfo) {
		bizContent.deviceInfo = deviceInfo;
		return this;
	}


	public String getNonceStr() {
		return bizContent.nonceStr;
	}


	public WxAppletBuilder setNonceStr(String nonceStr) {
		bizContent.nonceStr = nonceStr;
		return this;
	}


	public String getSign() {
		return bizContent.sign;
	}


	public WxAppletBuilder setSign(String sign) {
		bizContent.sign = sign;
		return this;
	}


	public String getSignType() {
		return bizContent.signType;
	}


	public WxAppletBuilder setSignType(String signType) {
		bizContent.signType = signType;
		return this;
	}


	public String getBody() {
		return bizContent.body;
	}


	public WxAppletBuilder setBody(String body) {
		bizContent.body = body;
		return this;
	}


	public String getDetail() {
		return bizContent.detail;
	}


	public WxAppletBuilder setDetail(String detail) {
		bizContent.detail = detail;
		return this;
	}


	public String getAttach() {
		return bizContent.attach;
	}


	public WxAppletBuilder setAttach(String attach) {
		bizContent.attach = attach;
		return this;
	}


	public String getOutTradeNo() {
		return bizContent.outTradeNo;
	}


	public WxAppletBuilder setOutTradeNo(String outTradeNo) {
		bizContent.outTradeNo = outTradeNo;
		return this;
	}


	public String getFeeType() {
		return bizContent.feeType;
	}


	public WxAppletBuilder setFeeType(String feeType) {
		bizContent.feeType = feeType;
		return this;
	}


	public BigDecimal getTotalFee() {
		return bizContent.totalFee;
	}


	public WxAppletBuilder setTotalFee(BigDecimal totalFee) {
		bizContent.totalFee = totalFee;
		return this;
	}


	public String getSpbillCreateIp() {
		return bizContent.spbillCreateIp;
	}


	public WxAppletBuilder setSpbillCreateIp(String spbillCreateIp) {
		bizContent.spbillCreateIp = spbillCreateIp;
		return this;
	}


	public String getTimeStart() {
		return bizContent.timeStart;
	}


	public WxAppletBuilder setTimeStart(String timeStart) {
		bizContent.timeStart = timeStart;
		return this;
	}


	public String getTimeExpire() {
		return bizContent.timeExpire;
	}


	public WxAppletBuilder setTimeExpire(String timeExpire) {
		bizContent.timeExpire = timeExpire;
		return this;
	}


	public String getGoodsTag() {
		return bizContent.goodsTag;
	}


	public WxAppletBuilder setGoodsTag(String goodsTag) {
		bizContent.goodsTag = goodsTag;
		return this;
	}


	public String getNotifyUrl() {
		return bizContent.notifyUrl;
	}


	public WxAppletBuilder setNotifyUrl(String notifyUrl) {
		bizContent.notifyUrl = notifyUrl;
		return this;
	}


	public String getTradeType() {
		return bizContent.tradeType;
	}


	public WxAppletBuilder setTradeType(String tradeType) {
		bizContent.tradeType = tradeType;
		return this;
	}


	public String getProductId() {
		return bizContent.productId;
	}


	public WxAppletBuilder setProductId(String productId) {
		bizContent.productId = productId;
		return this;
	}


	public String getLimitPay() {
		return bizContent.limitPay;
	}


	public WxAppletBuilder setLimitPay(String limitPay) {
		bizContent.limitPay = limitPay;
		return this;
	}


	public String getOpenId() {
		return bizContent.openId;
	}


	public WxAppletBuilder setOpenId(String openId) {
		bizContent.openId = openId;
		return this;
	}
}