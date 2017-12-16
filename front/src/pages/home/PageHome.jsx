import { Component, LogicRender } from 'refast';
import { render } from 'react-dom';
import SearchWord from 'components/search-word';
import SearchData from 'components/search-data';
import './PageHome.less';
import * as logic from './logic';

class PageHome extends Component {

  constructor(props) {
    super(props, logic);
    this.handleChange = this.handleChange.bind(this);
  }

  handleChange(e) {
    this.dispatch(['updateState', 'search'], { workNo: e.target.value });
  }

  render() {
    const { state: { data, workNo, empty, loading }, handleChange } = this;
    return (
      <div className="page-home">
        <input
          className="kuma-input"
          onChange={handleChange}
          placeholder="请输入员工工号"
          value={workNo}
        />
        <SearchWord workNo={workNo} />
        <LogicRender empty={empty} loading={loading}>
          <SearchData data={data} />
        </LogicRender>
      </div>
    );
  }
}
render(<PageHome />, document.getElementById('App'));
