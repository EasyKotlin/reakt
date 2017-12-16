import { Component, LogicRender } from 'refast';
import { render } from 'react-dom';
import SearchWord from 'components/search-word';
import SearchData from 'components/search-data';
import './PageDemo.less';
import * as logic from './logic';

class PageDemo extends Component {

  constructor(props) {
    super(props, logic);
    this.handleChange = this.handleChange.bind(this);
  }

  handleChange(e) {
    this.dispatch('updateState', { workNo: e.target.value });
  }

  render() {
    const {
      state: { data, workNo, empty },
      handleChange,
    } = this;
    return (
      <div className="page-demo">
        <input
          className="kuma-input"
          onChange={handleChange}
          placeholder="请输入员工工号"
          value={workNo}
        />
        <SearchWord workNo={workNo} />
        <LogicRender empty={empty} awareOf={{ workNo }} action="search">
          <SearchData data={data} />
        </LogicRender>
      </div>
    );
  }
}
render(<PageDemo />, document.getElementById('App'));


