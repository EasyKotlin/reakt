
import { render } from 'react-dom';
import { Component } from 'refast';
import logic from './logic';
import './PageArticleList.less';

class PageArticleList extends Component {

  constructor(props) {
    super(props, logic);
  }

  render() {
    return (
      <div className="page-article_list">
        page article_list
      </div>
    );
  }
}

render(<PageArticleList />, document.getElementById('App'));
