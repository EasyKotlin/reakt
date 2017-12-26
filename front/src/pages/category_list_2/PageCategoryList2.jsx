import {render} from 'react-dom';
import {Component} from 'refast';
import logic from './logic';
import './PageCategoryList2.less';
import CategoryList2 from "../../components/category_list_2/CategoryList2";
import Topnavbar from "../../components/topnavbar/Topnavbar";
import Footer from "../../components/footer/Footer";

export default class PageCategoryList2 extends Component {

  constructor(props) {
    super(props, logic);
  }

  render() {
    return (
      <div>
        <Topnavbar/>
        <div className="page-category_list_2">
          <CategoryList2/>
        </div>
        <Footer/>
      </div>
    );
  }
}

render(<PageCategoryList2/>, document.getElementById('App'));
