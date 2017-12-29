import {Component} from 'react';
import './ArticleEditor.less';

const classnames = require('classnames');
const Button = require('uxcore-button');
const Form = require('uxcore-form');
const PickableFormField = require('uxcore-pickable-form-field');

const {
  Constants,
  FormRowTitle,
  FormRow,
  FormField,
  InputFormField,
  Validators,
  RadioGroupFormField,
  SelectFormField,
  TextAreaFormField,
  NumberInputFormField,
  DateFormField,
  CheckboxGroupFormField,
  CascadeSelectFormField,
  OtherFormFieconstld,
  ButtonGroupFormField,
  EditorFormField,
  SwitchFormField,
  OtherFormField,

} = Form;

const CheckboxItem = CheckboxGroupFormField.Item;
const RadioItem = RadioGroupFormField.Item;
const {Count, LeftAddon, RightAddon} = InputFormField;
const Option = SelectFormField.Option;


export default class ArticleEditor extends Component {

  constructor(props) {
    super(props);
    this.state = {
      showPass: false,
      jsxvalues: {
        title: '标题',
      },
      mode: Constants.MODE.EDIT,
    };
  }

  handleClick() {
    const me = this;
    console.log(JSON.stringify(me.refs.form.getValues(true)));
  }

  handleSetValues() {
    const me = this;
    me.refs.form.setValues({
      title: '测试1',
    });
  }

  handleShowPassChange() {
    const me = this;
    me.setState({
      showPass: !me.state.showPass,
    });
  }

  handleFormClick(data) {
    this.refs.form.setState({
      mode: Constants.MODE.VIEW,
    });
  }

  update() {
    console.log('work');
    this.forceUpdate();
  }

  handleChange(value, name, pass) {
    console.log(value, name, pass);
    const me = this;
  }

  handleKeyDown(e) {
    if (e.keyCode == Form.KeyCode.Enter) {
      console.log('enter');
    }
  }

  handleTextAreaBlur(e, pass) {
    console.log(e, pass);
  }

  changeMode() {
    this.setState({
      mode: this.state.mode == Constants.MODE.EDIT ? Constants.MODE.VIEW : Constants.MODE.EDIT,
    });
  }

  handleValueChange() {
    const me = this;
    me.setState({
      jsxvalues: {
        title: '测试2'
      },
      jsxdata: {
        bj: '北',
        nj: '南',
        dj: '东',
        xj: '西',
      },
    });
  }

  render() {
    const me = this;
    const data = {
      title: '测试3'
    };

    return (
      <div className="mod-article_editor">
        <Form ref="form" instantValidate jsxmode={me.state.mode} jsxvalues={me.state.jsxvalues}
              jsxonChange={me.handleChange.bind(me)}>
          <FormRowTitle jsxtitle="写文章"/>
          <FormRow>
            <InputFormField
              labelMatchInputHeight
              required
              jsxname="title"
              jsxdisabled={false}
              autoTrim={false}
              jsxlabel="标题"
              jsxtips="请输入文章标题"
              validateOnBlur={false}
              onKeyDown={me.handleKeyDown.bind(me)}
              jsxrules={{validator: Validators.isNotEmpty, errMsg: '不能为空'}}
            >
              <LeftAddon>
                <i className="kuma-icon kuma-icon-document"/>
              </LeftAddon>
              <RightAddon>
                <span style={{lineHeight: '24px'}}></span>
              </RightAddon>
              <Count total={20}/>
            </InputFormField>
          </FormRow>

          <FormRow>
            <SwitchFormField jsxname="switch" jsxlabel="发布" checkedChildren="是" unCheckedChildren="否"/>
          </FormRow>

          <FormRow>
            <DateFormField format="yyyy-MM-dd"
                           jsxname="date"
                           jsxlabel="日期"
                           locale="zh-cn"
            />
          </FormRow>

          <FormRow>
            <SelectFormField
              jsxlabel="标签"
              jsxname="goods2"
              multiple
              jsxfetchUrl="http://suggest.taobao.com/sug"
              jsxdata={{
                a: 'A',
                b: 'B',
              }}
              beforeFetch={function (data) {
                console.log(data);
                if (data.q == undefined) {
                  data.q = 'a';
                }
                return data;
              }}
              dataType="jsonp"
              afterFetch={(obj) => {
                const data = {};
                obj.result.forEach((item, index) => {
                  data[item[1]] = item[0];
                });
                return data;
              }}
            />

          </FormRow>


          <EditorFormField jsxname="editor"
                           jsxlabel="内容"
                           placeholder="请在这里写文章正文"
          />

          <OtherFormField className="other">
            <Button style={{marginLeft: '88px', marginRight: '8px'}} onClick={me.handleClick.bind(me)}>提交</Button>
            <Button style={{marginRight: '8px'}} type="secondary" action="reset">取消</Button>
          </OtherFormField>

        </Form>
      </div>
    );
  }
}
