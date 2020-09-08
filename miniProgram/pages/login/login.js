// pages/login/login.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
      
  },

  forget_pwd: function (e) {
    wx.showModal({
      title: '忘记密码',
      content: '请发送邮件给管理员！sxmh_OUC@163.com',
      showCancel: false,
    })
  },
  login: function (e) {
    let data = e.detail.value;
    wx.request({
      url: 'http://sunshine-sun.cn:8080/user/login', 
      method: 'POST',
      data: {
        mail: data.user,
        password: data.password
      },
      success(res) {
        if (res.data.code === 200) {
          //保存返回的数据到全局对象
          app.globalData.userInfo=res.data.data;
          wx.showToast({
            title: '登录成功',
            icon: 'success'
          });
          //跳转页面
          wx.switchTab({
            url: '/pages/index/index',
          });
        }
      }
    })
  },
  register: function (e) {
    wx.navigateTo({
      url: '/pages/register/register',
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})