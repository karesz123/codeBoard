import {Component} from "react";
import PropTypes  from 'prop-types';

class InputField extends Component {

    render() {
        return (
            <div>
                <input className={"form-control"} type={this.props.type} name={this.props.name} placeholder={this.props.placeholder}
                       required autoComplete="false" onChange={this.props.handleChange}/>
                <label for={this.props.name}/>
            </div>
        )
    }
}

InputField.propTypes = {
    name: PropTypes.string,
    type: PropTypes.string,
    placeholder: PropTypes.string,
    handleChange: PropTypes.string
}

export default InputField;