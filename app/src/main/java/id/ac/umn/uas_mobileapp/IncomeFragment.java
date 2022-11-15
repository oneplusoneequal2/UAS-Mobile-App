package id.ac.umn.uas_mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class IncomeFragment extends Fragment {
    private EditText inputNominal, date;
    private Spinner saldoSpinner, kategoriSpinner;
    private String tipeTransaksi, kategoriInput, saldoInput;
    int nominal;
    FloatingActionButton add;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_income, container, false);
        inputNominal = view.findViewById(R.id.nominalIncome);

        date = view.findViewById(R.id.dateIncome);

        tipeTransaksi = "Income";


        kategoriSpinner = view.findViewById(R.id.kategoriIncome);
        ArrayAdapter<CharSequence> adapterKategori = ArrayAdapter.createFromResource(getContext(), R.array.kategoriIncome, android.R.layout.simple_spinner_item);
        kategoriSpinner.setAdapter(adapterKategori);
        kategoriSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                kategoriInput = kategoriSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        saldoSpinner = view.findViewById(R.id.saldoIncome);
        ArrayAdapter<CharSequence> adapterSaldo = ArrayAdapter.createFromResource(getContext(), R.array.saldo, android.R.layout.simple_spinner_item);
        saldoSpinner.setAdapter(adapterSaldo);
        saldoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                saldoInput = saldoSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        add = view.findViewById(R.id.addIncome);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nominal = Integer.parseInt(inputNominal.getText().toString());
                Intent intent = new Intent(getContext(), Transaksi.class);
                Bundle bundle = new Bundle();
                bundle.putString("tipeTransaksi", tipeTransaksi);
                bundle.putInt("nominal",nominal);
                bundle.putString("kategori",kategoriInput);
                bundle.putString("saldo", saldoInput);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        return view;
    }
}
