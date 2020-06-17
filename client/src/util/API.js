import axios from 'axios'
import qs from 'qs'

let config = {
	baseURL: 'http://39.106.160.119:8080',
	method: 'post',
	userLogin: {url: '/uesr/login'},
}
let API = {}

for (var elm in config) {
  API[elm] = (function (innerConfig,api) {
    console.log(api)
    return function (data, context) {
      return new Promise((resolve) => {

        let apiInfo = innerConfig[api]
        let method = apiInfo.method || innerConfig.method

        let config = {
          baseURL: innerConfig.baseURL,
          url: apiInfo.url,
          method: method,
          data: qs.stringify(data),
        }

        console.log(config)

        axios(config).then((res) => {
          try {
            let apiData = res.data
            console.log(apiData)

            // 异常响应
            if (apiData.code !== 0) {
              //alert(apiData.message)
              if (context) {
                context.error({statusCode: 500, message: `CODE[${apiData.code}] ERROR[${apiData.message}]`})
                resolve({})
              } else {
                resolve(apiData)
              }
            }
            resolve(apiData.data)
            console.log(apiData.data)
          } catch (err){/**/}
        }).catch()
      })
    }
  })(config,elm)
}

export default API;