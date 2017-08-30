import React, {Component} from 'react';
import SearchResult from "../components/search-result";
import {connect} from 'react-redux';

class SearchResults extends Component {

    render() {
        return (
            <div>
                {this.props.results.map(i => {
                    console.log(i.value)
                    return <SearchResult key={i.id} value={i.value}/>;
                })}
            </div>
        );
    }

}

const mapStateToProps = (state) => {
    results: state.results
};

export default connect(mapStateToProps)(SearchResults)