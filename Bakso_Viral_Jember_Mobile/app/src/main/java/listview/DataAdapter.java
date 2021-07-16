package listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bakso_viral_jember_mobile.R;

import java.util.ArrayList;


public class DataAdapter  extends RecyclerView.Adapter<DataAdapter.DataViewHolder>{

    private ArrayList<Data> dataList;

    public DataAdapter(ArrayList<Data> dataList){
        this.dataList = dataList;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        holder.txtJenis.setText(dataList.get(position).getJenis());
        holder.txtProduk.setText(dataList.get(position).getNama_produk());
        holder.txtHarga.setText(dataList.get(position).getHarga());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class DataViewHolder extends RecyclerView.ViewHolder{
        private TextView txtJenis, txtProduk, txtHarga;

        public DataViewHolder(View itemView) {
            super(itemView);
            txtJenis = (TextView) itemView.findViewById(R.id.tv_jenis);
            txtProduk = (TextView) itemView.findViewById(R.id.tv_nama);
            txtHarga = (TextView) itemView.findViewById(R.id.tv_harga);
        }
    }
}
