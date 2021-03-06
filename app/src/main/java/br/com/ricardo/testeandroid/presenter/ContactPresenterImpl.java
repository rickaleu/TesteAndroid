package br.com.ricardo.testeandroid.presenter;

import android.util.Log;

import br.com.ricardo.testeandroid.model.Cell;
import br.com.ricardo.testeandroid.model.ContactApp;
import br.com.ricardo.testeandroid.model.ContactInteractor;
import br.com.ricardo.testeandroid.view.ContactView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactPresenterImpl implements ContactPresenter{

    private ContactView contactView;
    private ContactInteractor contactInteractor;

    //Construtor com o atributo do tipo ContactInteractor(Model)
    public ContactPresenterImpl(ContactInteractor contactInteractor) {
        this.contactInteractor = contactInteractor;
    }

    @Override
    public void attachView(ContactView view) {
        contactView = view;
    }

    @Override
    public void detachView() {
        contactView = null;
    }

    @Override
    public void requestContactsField() {

        contactInteractor.requestContactsField().enqueue(new Callback<ContactApp>() {
            @Override
            public void onResponse(Call<ContactApp> call, Response<ContactApp> response) {

                if(!response.isSuccessful()){
                    Log.i("TAG", "Erro: " + response.code());
                } else{
                    ContactApp contactApp = response.body();

                    if(contactApp != null){
                        for(Cell c : contactApp.getCells()){

                            contactView.addTextField(c);
                        }
                    } else {
                        Log.i("TAG", "Erro: Json vazio.");
                    }
                }
            }

            @Override
            public void onFailure(Call<ContactApp> call, Throwable t) {
                Log.i("TAG", "Erro: Conexão falhou.");
            }
        });

    }
}
