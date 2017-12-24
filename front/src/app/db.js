import nattyFetch from 'natty-fetch';
import {isDev, urlPrefix} from './variables';

// See https://github.com/Jias/natty-fetch for more details.
const context = nattyFetch.context({
  mockUrlPrefix: urlPrefix,
  mock: isDev,
  // jsonp: true,
  withCredentials: false,
  traditional: true,
  data: {
    _tb_token_: '',
  },
  timeout: 5000,
  fit(response) {
    return {
      success: response.success,
      content: response.content,
      error: {
        errorMsg: response.errorMsg,
        errorCode: response.errorCode,
        errorLevel: response.errorLevel,
      },
    };
  },
});

export default context.api;
