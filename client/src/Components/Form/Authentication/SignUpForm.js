import {Component} from "react";
import InputField from "../InputField"
import PropTypes  from 'prop-types';
import {Link} from "react-router-dom";

class SignUpForm extends Component {

    constructor(props) {
        super(props);

        this.state = {
            name: "",
            userName: "",
            email: "",
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
                    <InputField type="text" name="name" placeholder="Name" handleChange={this.handleChange}/>
                    <InputField type="text" name="userName" placeholder="Username" handleChange={this.handleChange}/>
                    <InputField type="text" name="email" placeholder="Email address" handleChange={this.handleChange}/>
                    <InputField type="password" name="password" placeholder="Password" handleChange={this.handleChange}/>
                    <input className={"btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0"} type="submit" value="SIGN UP"/>
                </form>
                <Link to="/" className="btn btn-primary">Login</Link>
            </div>
        )
    }
}

SignUpForm.propTypes = {
    submit: PropTypes.string
}

export default SignUpForm;