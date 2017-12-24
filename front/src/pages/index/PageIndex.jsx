import {Component, LogicRender} from 'refast';
import {render} from 'react-dom';
import './PageIndex.less';
import * as logic from './logic';
import Topnavbar from "../../components/topnavbar/Topnavbar";
import Footer from "../../components/footer/Footer";
import {Icon} from "uxcore";

export default class PageIndex extends Component {

  constructor(props) {
    super(props, logic);
    this.handleChange = this.handleChange.bind(this);
  }

  handleChange(e) {
    this.dispatch(['updateState', 'search'], {workNo: e.target.value});
  }

  render() {
    const {state: {data, workNo, empty, loading}, handleChange} = this;
    return (
      <div>
        <Topnavbar />
        <div className="page-index">
          <div className="site-banner">
            <div className='kotlin-icon'></div>
            <div className='spring-boot-icon'></div>
            <div className='welcome'>Kotlin + Spring Boot: 下一代企业级开发</div>
          </div>
          <ul id="site-feature" className="site-feature">
            <li className="feature-item">
              <div className="feature-item-feature">
                <div className="feature-item-text">
                  <div className="feature-item-title">
                    <a href={'http://kotlinlang.org/'} target={'_blank'}>
                      <Icon name="chenggong-full"/>
                      Kotlin
                    </a>
                  </div>
                  <div className="feature-item-des">极具前景的现代编程语言:
                    <ul>
                      <li><strong>Statically typed, OOP && FP, Multiplatform</strong></li>
                      <li>100% interoperable with Java™ and Android™</li>
                      <li>
                        <strong>Concise:</strong>
                        Drastically reduce the amount of boilerplate code.
                      </li>
                      <li>
                        <strong>Safe:</strong>
                        Avoid entire classes of errors such as null pointer exceptions.
                      </li>
                      <li>
                        Tool-friendly: 使用 IDEA 开发如丝般润滑
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </li>
            <li className="feature-item">
              <div className="feature-item-feature">
                <div className="feature-item-text">
                  <div className="feature-item-title">
                    <a href={'http://projects.spring.io/spring-boot/'} target={'_blank'}>
                      <Icon name="chenggong-full"/>
                      Spring Boot
                    </a>
                  </div>
                  <div className="feature-item-des">
                    Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you
                    can "just run".
                    <ul>
                      <li><strong>自动化配置 Spring:</strong>极简 Spring 开发</li>
                      <li><strong>一键运行</strong>
                        Stand-alone Spring applications: Embed Tomcat, Jetty or Undertow directly
                      </li>
                      <li><strong>自动管理依赖库</strong>'starter' POMs</li>
                      <li><strong>自动化运维监控</strong>metrics, health checks and externalized configuration</li>
                      <li><strong>ZERO XML configuration</strong>Absolutely no code generation and no requirement for
                        XML configuration
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </li>
            <li className="feature-item">
              <div className="feature-item-feature">
                <div className="feature-item-text">
                  <div className="feature-item-title">
                    <a href='https://reactjs.org/' target='_blank'>
                      <Icon name="chenggong-full"/>
                      React
                    </a>
                  </div>
                  <div className="feature-item-des">A JavaScript library for building user interfaces
                    <ul>
                      <li><strong>Declarative:</strong> React will efficiently update and render just the right
                        components when your data changes.
                      </li>
                      <li><strong>Component-Based:</strong>Build encapsulated components that manage their own state,
                        then compose them to make complex UIs.
                      </li>
                      <li><strong>Learn Once, Write Anywhere:</strong>React can also render on the server using Node and
                        power mobile apps using React Native.
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </li>
            <li className="feature-item">
              <div className="feature-item-feature">
                <div className="feature-item-text">
                  <div className="feature-item-title">
                    <a href={'https://nodejs.org/'} target={'_blank'}>
                      <Icon name="chenggong-full"/>
                      Node
                    </a>
                  </div>
                  <div className="feature-item-des">Node.js® is a JavaScript runtime built on Chrome's V8 JavaScript
                    engine.
                    <ul>
                      <li><strong>Event-driven, non-blocking I/O: </strong>lightweight and efficient</li>
                      <li><strong>NPM:</strong>Node.js' package ecosystem, npm, is the largest ecosystem of open source
                        libraries in the world.
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </li>
            <li className="feature-item">
              <div className="feature-item-feature"><i className="alifont icon-xitongdingzhi"></i>
                <div className="feature-item-text">
                  <div className="feature-item-title">
                    <a href={'https://gradle.org/'} target={'_blank'}>
                      <Icon name="chenggong-full"/>
                      Gradle
                    </a>
                  </div>
                  <div className="feature-item-des">
                    <strong>Accelerate developer productivity : </strong>
                    From mobile apps to microservices, from small startups to big enterprises, Gradle helps teams build,
                    automate and deliver better software, faster.
                    <strong>Gradle is the best build system for the JVM.</strong>
                  </div>
                </div>
              </div>
            </li>
            <li className="feature-item">
              <div className="feature-item-feature"><i className="alifont icon-maintain"></i>
                <div className="feature-item-text">
                  <div className="feature-item-title">
                    <a href={'https://nowa-webpack.github.io/nowa/'} target={'_blank'}>
                      <Icon name="chenggong-full"/>
                      Nowa
                    </a>
                  </div>
                  <div className="feature-item-des">
                    快速上手 Webpack & React 开发生态环境, 整合 React、Babel、Reflux 等开源技术，一整套开发调试方案
                  </div>
                </div>
              </div>
            </li>
          </ul>
          <Footer/>
        </div>
      </div>

    );
  }
}


render(<PageIndex/>, document.getElementById('App'));
