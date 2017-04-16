package sv.edu.uesocc.ingenieria.ipam2017.firsthomework;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Cliente[] lista = new Cliente[] {
            new Cliente(1,"Victor","Carranza","Mayorista","Contado","00900300-1"),
            new Cliente(2,"Gabriela","Menendez","Mayorista","Anticipado","07001000-2"),
            new Cliente(3,"Christian","Contreras","Minorista","Credito","00030040-6")
    };

    private ListView lstClientes;

    private AdaptadorClientes adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adaptador = new AdaptadorClientes(this, lista);

        lstClientes =(ListView)findViewById(R.id.lstListaClientes);
        lstClientes.setAdapter(adaptador);

        lstClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cliente ClienteSeleccionado = (Cliente) parent.getAdapter().getItem(position);
                Toast.makeText(MainActivity.this,"El Cliente es: " +
                        ClienteSeleccionado.getNombre() + " "
                        + ClienteSeleccionado.getApellido(),Toast.LENGTH_LONG).show();
            }
        });
    }

    class AdaptadorClientes extends ArrayAdapter<Cliente>
    {
        Activity context;

        public AdaptadorClientes(Activity context, Cliente[] datos){
            super(context,R.layout.listitem_cliente,datos);

        }

        public View getView(int posicion, View convertView, ViewGroup parent)
        {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_cliente, null);

            TextView lblCod = (TextView)item.findViewById(R.id.LblCod);
            TextView lblNombre = (TextView)item.findViewById(R.id.LblNombre);
            TextView lblApellidos = (TextView)item.findViewById(R.id.LblApellidos);
            TextView lblTipo = (TextView)item.findViewById(R.id.LblTipo);
            TextView lblFormaPago = (TextView)item.findViewById(R.id.LblFormaPago);
            TextView lblDui = (TextView)item.findViewById(R.id.LblDui);

            lblCod.setText(Integer.toString(lista[posicion].getCodigo()));
            lblNombre.setText(lista[posicion].getNombre());

            lblApellidos.setText(lista[posicion].getApellido());
            lblTipo.setText(lista[posicion].getTipo());
            lblFormaPago.setText(lista[posicion].getFormaPago());
            lblDui.setText(lista[posicion].getDUI());

            return (item);
        }



    }
}
