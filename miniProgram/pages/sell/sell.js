// pages/sell/sell.js
Page({
 
  /**
   * 页面的初始数据
   */
 
  data: {
    
  },
  /**
   * 生命周期函数--监听页面加载
   */
  uploadBook:function(e){
    let data = e.detail.value;
    wx.request({
      url: 'http://sunshine-sun.cn:8080//usedbook/add',
      method: 'POST',
      data: {
        bookname: data.bookname,
        author: data.author,
        publisher: data.publisher,
        recency: data.recency,
        note: data.note,
        prcie: data.price
      },
      success(res) {
        console.log(res.data);
        if (res.data.code === 200) {
          //保存返回的数据到全局对象
          console.log(app.globalData.userInfo);
          //跳转页面
          wx.navigateTo({
            url: '/pages/_public/_pulic',
          });
        }
      }
    })
  },
  onLoad: function (options) {
    var that = this;
    wx.getSystemInfo({
      success: function (res) {
        console.log(res);
        // 屏幕宽度、高度
        console.log('height=' + res.windowHeight);
        console.log('width=' + res.windowWidth);
        // 高度,宽度 单位为px
        that.setData({
          windowWidth:  res.windowWidth,
          windowHeight:  res.windowHeight,
        })
      }
    })
  },
 
 
 
  
 
 
 
  get_name:function(e){
    console.log(e.detail);
    var that=this;
 
    if (!that.data.is_anonymous) {
      if (e.detail.cursor > 4) {
        wx.showToast({
          title: '姓名不能超过四个字符',
          icon: 'none',
          duration: 2000
        });
        
      }
    }
      that.setData({
        name: e.detail
      });
  },
 
  is_anonymous:function(e){
    console.log(e.detail);
    var that = this;
    that.setData({
      is_anonymous: e.detail.value
    });
 
  },
 
 
  get_textarea:function(e){
    console.log(e.detail);
    var that = this;
    that.setData({
      textarea: e.detail.value
    });
 
  },
  uploader: function () {
    var that = this;
    let imagesList = [];
    let maxSize = 1024 * 1024;
    let maxLength = 6;
    let flag = true;
    wx.chooseImage({
      count: 6, //最多可以选择的图片总数
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        wx.showToast({
          title: '正在上传...',
          icon: 'loading',
          mask: true,
          duration: 500
        })
        for (let i = 0; i < res.tempFiles.length; i++) {
          if (res.tempFiles[i].size > maxSize) {
            flag = false;
            console.log(111)
            wx.showModal({
              content: '图片太大，不允许上传',
              showCancel: false,
              success: function (res) {
                if (res.confirm) {
                  console.log('用户点击确定')
                }
              }
            });
          }
        }
        if (res.tempFiles.length > maxLength) {
          console.log('222');
          wx.showModal({
            content: '最多能上传' + maxLength + '张图片',
            showCancel: false,
            success: function (res) {
              if (res.confirm) {
                console.log('确定');
              }
            }
          })
        }
        if (flag == true && res.tempFiles.length <= maxLength) {
          that.setData({
            imagesList: res.tempFilePaths
          })
        }
        console.log(res);
      },
      fail: function (res) {
        console.log(res);
      }
    })
  },
  submit: function (res) {
    console.log(res);
    var that = this;
    if (!that.data.is_anonymous){
      if (that.data.name.cursor>4){
        wx.showToast({
          title: '姓名不能超过四个字符',
          icon: 'none',
          duration: 2000
        });
        return false;
}
    }
 
 
var id=false;
    wx.showLoading({
      title: '上传中...',
 
    })
    wx.request({
      url: 'https://www.top/index.php/api/index/index',
      method: 'post',
      data: {
        name: that.data.name.value,
        phone: that.data.phone.value,
        is_anonymous: that.data.is_anonymous,
        textarea: that.data.textarea
      }, success: function (res) {
        console.log(res);
        if (res.data.success){
          id = res.data.id;
          for (let i = 0; i < that.data.imagesList.length; i++) {
            wx.uploadFile({
              url: 'https://www.top/index.php/api/index/upload.html?id=' + id,
              filePath: that.data.imagesList[i],
              name: 'uploadfile_ant',
              header: {
                "Content-Type": "multipart/form-data"
                // 'Content-Type': 'application/json'
              },
              success: function (data) {
                if ((that.data.imagesList.length - 1)==i){
                  wx.hideLoading();
                  wx.showToast({
                    title: '成功',
                    icon: 'success',
                    duration: 2000
                  })
               
                  that.setData({
                    imagesList: []
                    , img: '/images/up.png',
                    file: '',
                    is_anonymous: false,
                    name: '',
                    phone: '',
                    textarea: ''
                  });
                  setTimeout(function () {
                    wx.navigateTo({
                      url: '../success/success',
                    })
                  }, 2000)
                  
}
              },
              fail: function (data) {
                console.log(data);
              }
            });
          }
        }
      }
    });
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