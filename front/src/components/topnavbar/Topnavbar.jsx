import {Component} from 'react';
import $ from 'jquery';
import './Topnavbar.less';
import {Icon} from "uxcore";

import {Link} from 'react-router'
import WekoolIcon from '../../images/wekool.svg'
import {URLS} from '../../app/variables'
import {isDev} from 'variables';

const Menu = require('uxcore-menu');
const SubMenu = Menu.SubMenu;
const MenuItem = Menu.Item;
window.Menu = Menu;

export default class Topnavbar extends Component {

  static defaultProps = {}

  static propTypes = {}


  constructor(props) {
    super(props);

    var index_url = isDev ? '/#/index' : 'index'
    var article_list_url = isDev ? '/#/article_list' : 'article_list'
    var category_list_url = isDev ? '/#/category_list' : 'category_list'
    var tag_list_url = isDev ? '/#/tag_list' : 'tag_list'

    let urls = {
      index_url: index_url,
      article_list_url: article_list_url,
      category_list_url: category_list_url,
      tag_list_url: tag_list_url,
    }

    this.state = {
      current: 'mail',
      urls: urls,
      username: ''
    }
  }

  handleClick(e) {
    console.log('click ', e);

    this.setState({
      current: e.key,
    });
  }

  componentDidMount() {
    console.log(`URLS.fetchCurrentUserUrl = ${URLS.fetchCurrentUserUrl}`)

    var u = localStorage.getItem("username")
    if (!u) {
      $.get(URLS.fetchCurrentUserUrl, function (result) {
        try {
          var currentUser = JSON.parse(result);
          console.log(`currentUser = ${currentUser}`)
          u = currentUser.loginUser.username
          localStorage.setItem("username", u)
        } catch (e) {
          // 如果 JSON.parse 解析异常，尝试直接对象访问
          console.log(e)
          currentUser = result;
          console.log(`currentUser = ${currentUser}`)
          u = currentUser.loginUser.username
          localStorage.setItem("username", u)
        }
      }.bind(this));
    }

    this.setState({
      username: u
    });

  }

  render() {

    return (
      <div>
        <a href="/" className="logo">
          <WekoolIcon/>
        </a>
        <Menu onClick={this.handleClick.bind(this)} selectedKeys={[this.state.current]} mode="horizontal">
          <Menu.Item key="index">
            <a href={this.state.urls.index_url}>
              <Icon name="shouye"> 首页</Icon>
            </a>
          </Menu.Item>

          <Menu.Item key="article">
            <a href={this.state.urls.article_list_url}>
              <Icon name="wendang1">文章</Icon>
            </a>
          </Menu.Item>

          <Menu.Item key="tag">
            <a href={this.state.urls.tag_list_url}>
              <Icon name="wendang1">标签</Icon>
            </a>
          </Menu.Item>

          <SubMenu title={<span><Icon name="renwufull">分类</Icon></span>}>
            <Menu.Item key="setting:1">
              <a href={this.state.urls.category_list_url}>
                <Icon name="right"> 行业分类</Icon>
              </a>
            </Menu.Item>
            <Menu.Item key="setting:2"><Icon name="right">Kotlin</Icon></Menu.Item>
            <Menu.Item key="setting:3"><Icon name="right">Spring Boot</Icon></Menu.Item>
            <Menu.Item key="setting:4"><Icon name="right">React</Icon></Menu.Item>
            <Menu.Item key="setting:5"><Icon name="right">Node</Icon></Menu.Item>
          </SubMenu>

          <Menu.Item key={'setting'}>
            <Icon name="shezhi">设置</Icon>
          </Menu.Item>

          <Menu.Item key="loginUser">
            <a href="#" target="">
              <Icon name="ren">{this.state.username}</Icon>
            </a>
          </Menu.Item>
        </Menu>
      </div>

    );
  }
}
