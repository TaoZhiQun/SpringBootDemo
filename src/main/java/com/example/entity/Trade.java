package com.example.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "t_trade")
public class Trade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "SEQ_T_TRADE")
	@Column(name = "id")
	private Long id;

	// 所属会员代码
	@Column(name = "member_id", nullable = false)
	@NotNull
	@Length(min = 1, max = 30)
	private String memberID;

	// 交易商代码（显示为会员客户）
	@Column(name = "trader_id", length = 30)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 30)
	private String traderID;
	
	// 合约代码
	@Column(name = "instrument_id", length = 30)
	private String instrumentID;

	// 结算日期
	@Column(name = "settle_date", nullable = false, length = 8)
	@NotNull
	@NotBlank
	@Length(min = 8, max = 8)
	private String settleDate;

	// 成交编号
	@Column(name = "trade_id",  length = 100)
	private String tradeID;
	
	//委托编号
	@Column(name = "order_id",length = 100)
	private String orderID;
	
	//成交对手方编号
	@Column(name = "opponent_id", length = 30)
	private String opponentID;
	
	// 买卖方向 0-买，1-卖,N-无值
	@Column(name = "direction",  length = 1)
	@Length(min = 0, max = 1)
	private String direction;

	// 开平标志 0-开仓，1-平仓
	@Column(name = "offset_flag", length = 1)
	@Length(min = 0, max = 1)
	private String offsetFlag;

	// 成交类型
	@Column(name = "trade_type", nullable = false, length = 2)
	@NotNull
	@NotBlank
	@Length(min = 0, max = 2)
	private String tradeType;

	// 成交数量
	@Column(name = "volume", precision = 20, scale = 6)
	@Digits(integer = 14, fraction = 6)
	private BigDecimal volume;

	// 委托数量
	@Column(name = "order_volume", nullable = false, precision = 20, scale = 6)
	@NotNull
	@Digits(integer = 14, fraction = 6)
	private BigDecimal orderVolume;
	
	// 成交价格
	@Column(name = "price",  precision = 20, scale = 6)
	@Digits(integer = 14, fraction = 6)
	private BigDecimal price;

	// 成交时间
	@Column(name = "trade_time", nullable = false, length = 8)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 8)
	private String tradeTime;

	// 成交金额
	@Column(name = "money", precision = 16, scale = 2)
	@Digits(integer = 14, fraction = 2)
	private BigDecimal money;

	// 冻结资金
	@Column(name = "frozen_money", nullable = false, precision = 16, scale = 2)
	@NotNull
	@Digits(integer = 14, fraction = 2)
	private BigDecimal frozenMoney;

	// 解冻资金
	@Column(name = "unfrozen_money", nullable = false, precision = 16, scale = 2)
	@NotNull
	@Digits(integer = 14, fraction = 2)
	private BigDecimal unfrozenMoney;

	// 增加货款
	@Column(name = "add_payment", nullable = false, precision = 16, scale = 2)
	@NotNull
	@Digits(integer = 14, fraction = 2)
	private BigDecimal addPayment;

	// 扣除货款
	@Column(name = "deduct_payment", nullable = false, precision = 16, scale = 2)
	@NotNull
	@Digits(integer = 14, fraction = 2)
	private BigDecimal deductPayment;

	// 其他收入
	@Column(name = "other_money", nullable = false, precision = 16, scale = 2)
	@NotNull
	@Digits(integer = 14, fraction = 2)
	private BigDecimal otherMoney;

	// 客户盈利
	@Column(name = "profit_money", nullable = false, precision = 16, scale = 2)
	@NotNull
	@Digits(integer = 14, fraction = 2)
	private BigDecimal profitMoney;

	// 支出费用
	@Column(name = "pay_money", nullable = false, precision = 16, scale = 2)
	@NotNull
	@Digits(integer = 14, fraction = 2)
	private BigDecimal payMoney;

	// 建仓价
	@Column(name = "establish_price", precision = 20, scale = 6)
	@Digits(integer = 14, fraction = 6)
	private BigDecimal establishPrice;
	
	// 预期收益率
	@Column(name = "expect_rate",length = 30)
	private String expectRate;
	
	// 增加保证金
	@Column(name = "add_margin", nullable = false,  precision = 16, scale = 2)
	private BigDecimal addMargin;

	// 扣除保证金
	@Column(name = "sub_margin",nullable = false,  precision = 16, scale = 2)
	private BigDecimal subMargin;
	
	// 开仓时间
	@Column(name = "open_position_time",length = 14)
	private  String openPositionTime;
	
	// 持仓变动方向（0冻结；1解冻；2增加；3扣除；4先扣除后增加；N无值）
	@Column(name = "position_change_direction", nullable = false, length = 1)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 1)
	private String positionChangeDirection;
	
	public String getPositionChangeDirection() {
		return positionChangeDirection;
	}

	public void setPositionChangeDirection(String positionChangeDirection) {
		this.positionChangeDirection = positionChangeDirection;
	}

	public String getOpenPositionTime() {
		return openPositionTime;
	}

	public void setOpenPositionTime(String openPositionTime) {
		this.openPositionTime = openPositionTime;
	}

	public BigDecimal getOrderVolume() {
		return orderVolume;
	}

	public void setOrderVolume(BigDecimal orderVolume) {
		this.orderVolume = orderVolume;
	}

	public BigDecimal getAddMargin() {
		return addMargin;
	}

	public void setAddMargin(BigDecimal addMargin) {
		this.addMargin = addMargin;
	}

	public BigDecimal getSubMargin() {
		return subMargin;
	}

	public void setSubMargin(BigDecimal subMargin) {
		this.subMargin = subMargin;
	}

	public String getExpectRate() {
		return expectRate;
	}

	public void setExpectRate(String expectRate) {
		this.expectRate = expectRate;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getOpponentID() {
		return opponentID;
	}

	public void setOpponentID(String opponentID) {
		this.opponentID = opponentID;
	}

	public String getTraderID() {
		return traderID;
	}

	public void setTraderID(String traderID) {
		this.traderID = traderID;
	}

	public String getInstrumentID() {
		return instrumentID;
	}

	public void setInstrumentID(String instrumentID) {
		this.instrumentID = instrumentID;
	}

	public String getSettleDate() {
		return settleDate;
	}

	public void setSettleDate(String settleDate) {
		this.settleDate = settleDate;
	}

	public String getTradeID() {
		return tradeID;
	}

	public void setTradeID(String tradeID) {
		this.tradeID = tradeID;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getOffsetFlag() {
		return offsetFlag;
	}

	public void setOffsetFlag(String offsetFlag) {
		this.offsetFlag = offsetFlag;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public BigDecimal getFrozenMoney() {
		return frozenMoney;
	}

	public void setFrozenMoney(BigDecimal frozenMoney) {
		this.frozenMoney = frozenMoney;
	}

	public BigDecimal getUnfrozenMoney() {
		return unfrozenMoney;
	}

	public void setUnfrozenMoney(BigDecimal unfrozenMoney) {
		this.unfrozenMoney = unfrozenMoney;
	}

	public BigDecimal getAddPayment() {
		return addPayment;
	}

	public void setAddPayment(BigDecimal addPayment) {
		this.addPayment = addPayment;
	}

	public BigDecimal getDeductPayment() {
		return deductPayment;
	}

	public void setDeductPayment(BigDecimal deductPayment) {
		this.deductPayment = deductPayment;
	}

	public BigDecimal getOtherMoney() {
		return otherMoney;
	}

	public void setOtherMoney(BigDecimal otherMoney) {
		this.otherMoney = otherMoney;
	}

	public BigDecimal getProfitMoney() {
		return profitMoney;
	}

	public void setProfitMoney(BigDecimal profitMoney) {
		this.profitMoney = profitMoney;
	}

	public BigDecimal getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}

	public BigDecimal getEstablishPrice() {
		return establishPrice;
	}

	public void setEstablishPrice(BigDecimal establishPrice) {
		this.establishPrice = establishPrice;
	}


}
