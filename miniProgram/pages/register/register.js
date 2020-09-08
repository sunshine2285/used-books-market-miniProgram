// pages/register/register.js

const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    
    
  },
 login:function(e){
   let data = e.detail.value;
   wx.request({
     url: 'http://sunshine-sun.cn:8080/user/register',
     method: 'POST',
     data: {
       college: data.collage,
       mail: data.email,
       major: data.major,
       password: data.password,
       tel: data.tel,
       username: data.user,
       year: data.grade
     },
     success(res) {
        console.log(res.data);
        if (res.data.code === 200) {
          //保存返回的数据到全局对象
          console.log(app.globalData.userInfo);
          wx.showToast({
            title: '注册成功',
            icon: 'success'
          });
          //跳转页面
          wx.navigateTo({
            url: '/pages/login/login',
          });
        }
     }
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