import {render} from 'react-dom';
import {Component} from 'refast';
import logic from './logic';
import './PageTagList.less';
import Footer from "../../components/footer/Footer";
import Topnavbar from "../../components/topnavbar/Topnavbar";

export default class PageTagList extends Component {

  constructor(props) {
    super(props, logic);
  }

  render() {
    return (
      <div>
        <Topnavbar/>
        <div className="page-tag_list">
          page tag_list
        </div>
        <Footer/>
      </div>
    );
  }
}

render(<PageTagList/>, document.getElementById('App'));
