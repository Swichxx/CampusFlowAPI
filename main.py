from flask import Flask
import folium
from folium.plugins import HeatMap
import psycopg2

app = Flask(__name__)

def gerar_mapa():
    conn = psycopg2.connect(
        host="ep-red-glitter-adx9s4na-pooler.c-2.us-east-1.aws.neon.tech",
        dbname="neondb",
        user="neondb_owner",
        password="npg_8jbKOq2MDZvT",
        sslmode="require"
    )
    cursor = conn.cursor()
    cursor.execute("""
        SELECT latitude, longitude, COUNT(DISTINCT device) as qtd_pessoas
        FROM access
        GROUP BY latitude, longitude
    """)
    rows = cursor.fetchall()
    conn.close()

    def normalizar(qtd, minimo=1, maximo=50):
        qtd = max(min(qtd, maximo), minimo)
        return (qtd - minimo) / (maximo - minimo)

    dados = [[lat, lon, normalizar(qtd)] for lat, lon, qtd in rows]

    mapa = folium.Map( zoom_start=0)
    HeatMap(dados, radius=24, blur=20, min_opacity=0.5,
            gradient={0: 'blue', 0.5: 'lime', 0.7: 'yellow', 1: 'red'}).add_to(mapa)

    return mapa._repr_html_()  # retorna o HTML direto

@app.route("/mapa")
def mapa():
    return gerar_mapa()

if __name__ == "__main__":
    app.run(debug=True)
