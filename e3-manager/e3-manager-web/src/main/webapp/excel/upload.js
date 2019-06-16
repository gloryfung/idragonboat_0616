/*// 导入excel文件
importData: function(event) {
      event.preventDefault();
      $("#uploadEventFile").trigger("click")
    },
    fileChange: function (el) {
      el.preventDefault();//取消默认行为
      let vm = this
      let uploadEventFile = $("#uploadEventFile").val()
      this.file = el.target.files[0]
      if (uploadEventFile == '') {
       alert("请择excel,再上传");
      } else if (uploadEventFile.lastIndexOf(".xls") > 0 || uploadEventFile.lastIndexOf(".XLS") > 0) {
        let formData = new FormData();
        // 向 formData 对象中添加文件
        formData.append('file',this.file);
        let config = {
        // 一定要定义头
          headers: {
            'Content-Type': 'multipart/form-data'
          }
        }
        // url为对应的后端接口
        vm.$http.post(url,formData,config).then(function (response) {
         alert('上传成功')
        })
      } else {
        alert("只能上传excel文件");
      }
    },
    // 下载文件
    download: function(){
       axios({
            method: "get",
            url: "xxx",
            responseType: "arraybuffer"
          })
          .then(
            function(response) {
              let filename = "poiImport.xlsx";
              this.fileDownload(response.data, filename);
            }.bind(this)
          )
          .catch(
            function(error) {
              alert("网络请求出错");
            }.bind(this)
          );
    },
    fileDownload = function (data, fileName) {
      let blob = new Blob([data], {
        type: "application/octet-stream"
      });
      let filename = fileName || "filename.xls";
      if (typeof window.navigator.msSaveBlob !== "undefined") {
        window.navigator.msSaveBlob(blob, filename);
      } else {
        var blobURL = window.URL.createObjectURL(blob);
        var tempLink = document.createElement("a");
        tempLink.style.display = "none";
        tempLink.href = blobURL;
        tempLink.setAttribute("download", filename);
        if (typeof tempLink.download === "undefined") {
          tempLink.setAttribute("target", "_blank");
        }
        document.body.appendChild(tempLink);
        tempLink.click();
        document.body.removeChild(tempLink);
        window.URL.revokeObjectURL(blobURL);
      }
    };*/