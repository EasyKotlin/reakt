import {Component} from 'react';
import './CategoryList2.less';
import {URLS} from "../../app/variables";
import {isDev} from 'variables';
import Title from 'uxcore-title';

const Table = require('uxcore-table');
const fetchUrl = URLS.category_list_url_2;

export default class CategoryList2 extends Component {

  static defaultProps = {}

  static propTypes = {}

  constructor(props) {
    super(props);
  }


  render() {
    const me = this;
    const columns = [
      {dataKey: 'code', title: 'Code', width: 200},
      {dataKey: 'name', title: 'Name', width: 400, type: 'text'},
      {
        dataKey: 'detail', title: 'Detail', width: 600, type: 'text',
        render(cellData, rowData) {
          console.log(`cellData = ${cellData}`)
          console.log(`rowData = ${rowData}`)
          return <div><a href="javascript:;">{cellData}</a></div>;
        }
      },

    ];
    const renderProps = {
      height: 600,
      pageSize: 10,
      fetchUrl: fetchUrl,
      fetchParams: {},
      jsxcolumns: columns,
      showSearch: true,
      searchBarPlaceholder: '搜索',
      showMask: true,
      emptyText: '暂无数据',
      loadingText: '数据加载中',
      addRowClassName: function (rowData) {
        return 'multiline'
      }
    };

    return (
      <div className="mod-category_list_2">
        <Title type="secondary">图书分类</Title>
        <Table {...renderProps} />
      </div>
    );
  }
}
