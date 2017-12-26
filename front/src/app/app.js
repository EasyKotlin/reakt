import Refast, {LogicRender} from 'refast';
import {Dialog, EmptyData, Message} from 'uxcore';
import {assign} from 'lodash';
import {isDev} from 'variables';
import DB from 'db';
import './app.less';

import React from 'react'
import {render} from 'react-dom'
import {browserHistory, hashHistory, IndexRedirect, IndexRoute, Redirect, Route, Router} from 'react-router'

import PageArticleList from "../pages/article_list/PageArticleList";
import PageTagList from "../pages/tag_list/PageTagList";
import PageIndex from "../pages/index/PageIndex";
import {URLS} from "./variables";
import PageCategoryList1 from "../pages/category_list_1/PageCategoryList1";
import PageCategoryList2 from "../pages/category_list_2/PageCategoryList2";
import PageCategoryList3 from "../pages/category_list_3/PageCategoryList3";


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


var his;
if (isDev) {
  //SPA
  his = hashHistory
} else {
  his = browserHistory
}

let routes =
  <Route path="/">
    <IndexRedirect to="index"/>
    <Route path="index" component={PageIndex}/>
    <Route path="article_list" component={PageArticleList}/>
    <Route path="category_list_1" component={PageCategoryList1}/>
    <Route path="category_list_2" component={PageCategoryList2}/>
    <Route path="category_list_3" component={PageCategoryList3}/>
    <Route path="tag_list" component={PageTagList}/>
  </Route>

let router = <Router routes={routes} history={his}/>
ReactDOM.render(router, document.getElementById('App'))

