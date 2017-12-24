import {Component} from 'react';
import './Footer.less';

export default class Footer extends Component {

  static defaultProps = {}

  static propTypes = {}

  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div className="mod-footer">
        <div className="footer-right">© 2017 Wekool, Inc.</div>
        <div className="footer-power">
          <span>BY 东海陈光剑</span>
        </div>
      </div>
    );
  }
}
