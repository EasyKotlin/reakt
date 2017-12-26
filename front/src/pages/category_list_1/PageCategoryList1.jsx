import {render} from 'react-dom';
import {Component} from 'refast';
import logic from './logic';
import './PageCategoryList1.less';
import CategoryList1 from "../../components/category_list_1/CategoryList1";
import Footer from "../../components/footer/Footer";
import Topnavbar from "../../components/topnavbar/Topnavbar";

export default class PageCategoryList1 extends Component {

  constructor(props) {
    super(props, logic);
  }

  render() {
    return (
      <div>
        <Topnavbar/>
        <div className="page-category_list_1">
          <CategoryList1/>
        </div>
        <Footer/>
      </div>

    );
  }
}

render(<PageCategoryList1/>, document.getElementById('App'));
