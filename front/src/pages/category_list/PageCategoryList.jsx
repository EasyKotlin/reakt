import {render} from 'react-dom';
import {Component} from 'refast';
import logic from './logic';
import './PageCategoryList.less';
import Topnavbar from "../../components/topnavbar/Topnavbar";
import Footer from "../../components/footer/Footer";
import CategoryList from "../../components/category_list/CategoryList";

export default class PageCategoryList extends Component {

  constructor(props) {
    super(props, logic);
  }

  render() {
    return (
      <div>
        <Topnavbar/>
        <div className="page-category_list">
          <CategoryList />
        </div>
        <Footer/>
      </div>
    );
  }
}

render(<PageCategoryList/>, document.getElementById('App'));
