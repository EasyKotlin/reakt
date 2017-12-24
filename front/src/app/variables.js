// 这里放置全局的变量:  __LOCAL__ 定义在 abc.json 里面
const isDev = __LOCAL__;
const urlPrefix = isDev ? '/mock/' : '/';

export default {
  urlPrefix,
  isDev,
    // 这里放置全局的调用的URL
  URLS: {
    query: `${urlPrefix}query/query.json`,
    fetchCurrentUserUrl: `${urlPrefix}user/currentUser.json`,
  },
};
