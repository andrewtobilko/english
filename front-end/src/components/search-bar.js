import React, {Component} from 'react';

class SearchBar extends Component {


    constructor(props) {
        super(props);

        this.state = {
            term: ''
        };
    }

    render() {
        return (
            <form>
                <input type="text" value={this.state.term} onChange={this.onInputChange.bind(this)}/>
                {this.state.term}
            </form>
        );
    }

    onInputChange(event) {
        this.setState({term: event.target.value});
    }

}

export default SearchBar;