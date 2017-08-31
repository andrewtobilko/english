import React, {Component} from 'react';
import {connect} from "react-redux";
import {bindActionCreators} from "redux";
import searchQueryChangedActionCreator from "../action-creators/search-query-changed.action-creator";

class SearchBar extends Component {

    onInputChange(event) {
        const properties = this.props;

        properties.searchQuery = event.target.input;
        console.log('onInputChange:props = ', properties, event.target.input);

        properties.searchQueryChanged(event.target.input)
    }

    render() {
        // if (!this.props.searchQuery) {
        //     return <div>Loading the search bar...</div>
        // }

        return (
            <div>
                <input type="text" onChange={event => this.onInputChange(event)}/>
                <div>input: {this.props.searchQuery}</div>
            </div>
        );
    }

}

function mapStateToProps(state) {
    console.log('mapStateToProps -> state: ', state);

    return {
        searchQuery: ''
    };
}

function mapDispatchToProps(dispatch) {
    return bindActionCreators(
        {
            searchQueryChanged: searchQueryChangedActionCreator
        },
        dispatch
    );
}

export default connect(mapStateToProps, mapDispatchToProps)(SearchBar);