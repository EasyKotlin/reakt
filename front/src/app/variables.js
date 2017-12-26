// 这里放置全局的变量:  __LOCAL__ 定义在 abc.json 里面
const isDev = __LOCAL__;
const HOST_NAME = __HOST_NAME__;
const urlPrefix = isDev ? '/mock/' : HOST_NAME;

export default {
  urlPrefix,
  isDev,
  // 这里放置全局的调用的URL
  URLS: {
    query: `${urlPrefix}query/query.json`,
    fetchCurrentUserUrl: `${urlPrefix}user/currentUser.json`,
    category_list_url_1: `${urlPrefix}/category/page.json?type=1`,
    category_list_url_2: `${urlPrefix}/category/page.json?type=2`,
    category_list_url_3: `${urlPrefix}/category/page.json?type=3`,
  },
};
