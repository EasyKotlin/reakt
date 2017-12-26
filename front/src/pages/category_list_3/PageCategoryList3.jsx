import {render} from 'react-dom';
import {Component} from 'refast';
import logic from './logic';
import './PageCategoryList3.less';
import CategoryList3 from "../../components/category_list_3/CategoryList3";
import Footer from "../../components/footer/Footer";
import Topnavbar from "../../components/topnavbar/Topnavbar";

export default class PageCategoryList3 extends Component {

  constructor(props) {
    super(props, logic);
  }

  render() {
    return (
      <div>
        <Topnavbar/>
        <div className="page-category_list_3">
          <CategoryList3/>
        </div>
        <Footer/>
      </div>
    );
  }
}

render(<PageCategoryList3/>, document.getElementById('App'));
