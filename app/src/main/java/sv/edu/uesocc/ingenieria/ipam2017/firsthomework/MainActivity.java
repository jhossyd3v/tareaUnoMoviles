package sv.edu.uesocc.ingenieria.ipam2017.firsthomework;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
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

        if(this.getIntent().hasExtra("clientAction")){
            Bundle datos = this.getIntent().getExtras();
            if(datos.getString("clientAction").equals("update")) {

            } else if(datos.getString("clientAction").equals("create")) {

            }
        }

        adaptador = new AdaptadorClientes(this, lista);

        lstClientes =(ListView)findViewById(R.id.lstListaClientes);
        lstClientes.setAdapter(adaptador);

        registerForContextMenu(lstClientes);

        lstClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cliente ClienteSeleccionado = (Cliente) parent.getAdapter().getItem(position);
                Intent intentEditar = new Intent(MainActivity.this, ClientForm.class);
                Bundle data = new Bundle();
                data.putString("clientAction","edit");
                data.putString("codigo",Integer.toString(ClienteSeleccionado.getCodigo()));
                data.putString("nombre",ClienteSeleccionado.getNombre());
                data.putString("apellido",ClienteSeleccionado.getApellido());
                data.putString("tipo",ClienteSeleccionado.getTipo());
                data.putString("pago",ClienteSeleccionado.getFormaPago());
                data.putString("dui",ClienteSeleccionado.getDUI());
                data.putInt("position",position);
                intentEditar.putExtras(data);
                startActivity(intentEditar);
            }
        });

//        Intent intentMostrar = new Intent(MainActivity.this,
//                MostrarNombre.class);
//
//        Bundle datos = new Bundle();
//        datos.putString("CARNET",txtNumCarnet.getText().toString());
//        intentMostrar.putExtras(datos);
//
//        startActivity(intentMostrar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.MnuOpc1:
                Intent intent = new Intent(MainActivity.this,ClientForm.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contexto,menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.MnuEliminar:
                //Toast.makeText(MainActivity.this, "Menu Restaurar", Toast.LENGTH_SHORT).show();
//                Toast.makeText(MainActivity.this, ClienteSeleccionado.getNombre(), Toast.LENGTH_SHORT).show();
//                adaptador.remove(ClienteSeleccionado);
//                lstClientes.setAdapter(adaptador);
                Toast.makeText(MainActivity.this, "Cliente Eliminado Exitosamente", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
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
