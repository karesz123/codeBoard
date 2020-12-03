import {Component} from "react";
import InputField from "../InputField"
import PropTypes  from 'prop-types';
import {Link} from "react-router-dom";

class LoginForm extends Component {

    constructor(props) {
        super(props);

        this.state = {
            userNameOrEmail: "",
            password: ""
        };
    }

    handleChange = (event) => {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    handleSubmit = (event) => {
        event.preventDefault();
        this.props.submit(JSON.stringify(this.state));
    }

    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <InputField type="text" name="userNameOrEmail" placeholder="Username or Email" handleChange={this.handleChange}/>
                    <InputField type="password" name="password" placeholder="Password" handleChange={this.handleChange}/>
                    <input className={"btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0"} type="submit" value="LOG IN"/>
                </form>
                <Link to="/signup" className="btn btn-primary">Sign up</Link>
            </div>
        )
    }
}

LoginForm.propTypes = {
    submit: PropTypes.string
}

export default LoginForm;