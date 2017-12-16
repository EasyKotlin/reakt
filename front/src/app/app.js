import Refast, { LogicRender } from 'refast';
import { Message, Dialog, EmptyData } from 'uxcore';
import { assign } from 'lodash';
import { isDev } from 'variables';
import DB from 'db';
import './app.less';

// This is a Chrome only hack
if (isDev && window.chrome && window.chrome.webstore) {
  // see https://github.com/livereload/livereload-extensions/issues/26
  setInterval(() => {
    document.body.focus();
  }, 200);
}

// Refast 文档请看 https://recore.github.io/refast-docs/
Refast.use('fn', {
  message: Message,
  dialog: Dialog,
  DB,
});

const Loading = () => <div className="kuma-loading" />;
const Empty = EmptyData || (() => <div>暂无数据</div>);

// 修改 LogicRender 增加默认配置
// 用来自定义Loading和Empty的样式
assign(LogicRender.defaultProps, { Empty, Loading });


