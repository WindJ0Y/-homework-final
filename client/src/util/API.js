import axios from 'axios'
import qs from 'qs'

let config = {
	baseURL: 'http://127.0.0.1:8848/api/v1',
	userLogin: {url: '/user/login'},
  userLogout: {url: '/user/logout'},
  userInfo: {url: '/user/info'},
  userReg: {url: '/user/register'},

  studentHomeworkList: {url: '/student/listhw'},
  studentHomeworkInfo: {url: '/student/infohw'},
  studentHomeworkSubmit: {url: '/student/submithw'},

  teacherHomeworkList: {url: '/teacher/listhw'},
  teacherHomeworkInfo: {url: '/teacher/infohw'},
  teacherHomeworkSubmit: {url: '/teacher/submithw'},

  teacherHomeworkAdd: {url: '/teacher/add'},
}
let API = {}

for (var elm in config) {
  API[elm] = (function (innerConfig,api) {
    return function (data) {
      return new Promise((resolve) => {

        let apiInfo = innerConfig[api]

        let config = {
          baseURL: innerConfig.baseURL,
          url: apiInfo.url,
          method: "post",
          data: qs.stringify(data),
        }

        console.log(config)

        axios(config).then((res) => {
          try {
            console.log(res.data);
            resolve(res.data);
          } catch (err){/**/}
        }).catch()
      })
    }
  })(config,elm)
}

export default API;