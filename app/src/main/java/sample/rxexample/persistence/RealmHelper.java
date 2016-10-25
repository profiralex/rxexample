package sample.rxexample.persistence;

import java.util.List;

import io.realm.Realm;
import sample.rxexample.model.SearchResult;

/**
 * Created by profiralexandr on 17/08/16.
 */

public class RealmHelper {
    private Realm mRealm;

    public RealmHelper(Realm realm) {
        mRealm = realm;
    }

    public void saveToRealm(List<SearchResult> results) {
        mRealm.beginTransaction();
        mRealm.copyToRealmOrUpdate(results);
        mRealm.commitTransaction();
    }

    public List<SearchResult> getAcronyms(String name) {
        return mRealm.copyFromRealm(mRealm.where(SearchResult.class).findAll());
    }

    public void close() {
        mRealm.close();
    }
}
