import {render} from 'react-dom';
import {Component} from 'refast';
import logic from './logic';
import './PageArticleList.less';
import Topnavbar from "../../components/topnavbar/Topnavbar";
import Footer from "../../components/footer/Footer";
import ArticleEditor from "../../components/article_editor/ArticleEditor";

export default class PageArticleList extends Component {

  constructor(props) {
    super(props, logic);
  }

  render() {
    return (
      <div>
        <Topnavbar/>
        <div className="page-article_list">
          <ArticleEditor/>
        </div>
        <Footer/>
      </div>
    );
  }
}

render(<PageArticleList/>, document.getElementById('App'));
