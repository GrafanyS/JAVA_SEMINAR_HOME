package Lesson3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WaveAlgorithm {
    public WaveAlgorithm(int[][] map) {
    }

    public static void main(String[] args) {
        //Печать карты
        var mg = new MapGenerator();
        //Установление координат начальной точки - 1
        Point2D ps = new Point2D(3,3);
        mg.setStart(ps);
        System.out.println("Пустая карта K - начало маршрута");
        System.out.println(
                new MapPrinter().mapColor(
                        mg.getMap())

        );

        var lee = new waveAlgorithm(mg.getMap());
        lee.SpreadWave(new Point2D(3, 3));
        System.out.println("Заполненная карта после оцифровки волновым алгоритмом");
        System.out.println(
                new MapPrinter().rawData(
                        mg.getMap())

        );
        //Нанесение на карьу маршрута с начальной точки 1 до конечной 19
        var rd = lee.getRoad(mg.setExit(19));
        lee.drawRoad(rd);
        System.out.println("Заполненная карта с маршрутом");
        System.out.println(
                new MapPrinter().mapColor(
                        mg.getMap()));

    }
}

class waveAlgorithm {
    int[][] map;

    public waveAlgorithm(int[][] map) {
        this.map = map;
    }

    // Волновая оцифровка поля от точки старта
    public void SpreadWave(Point2D startPoint) {
        Queue<Point2D> queue = new LinkedList<Point2D>();
        queue.add(startPoint);
        map[startPoint.x][startPoint.y] = 1;

        while (queue.size() != 0) {
            Point2D p = queue.remove();

            if (map[p.x - 1][p.y] == 0) {
                queue.add(new Point2D(p.x - 1, p.y));
                map[p.x - 1][p.y] = map[p.x][p.y] + 1;
            }
            if (map[p.x][p.y - 1] == 0) {
                queue.add(new Point2D(p.x, p.y - 1));
                map[p.x][p.y - 1] = map[p.x][p.y] + 1;
            }
            if (map[p.x + 1][p.y] == 0) {
                queue.add(new Point2D(p.x + 1, p.y));
                map[p.x + 1][p.y] = map[p.x][p.y] + 1;
            }
            if (map[p.x][p.y + 1] == 0) {
                queue.add(new Point2D(p.x, p.y + 1));
                map[p.x][p.y + 1] = map[p.x][p.y] + 1;
            }
        }
    }

    // Формирование массива точек машрута от конечной до начальной точки
    public ArrayList<Point2D> getRoad(Point2D exitPoint) {
        ArrayList<Point2D> road = new ArrayList<>();
        road.add(new Point2D(exitPoint.x, exitPoint.y));
        Point2D p = exitPoint;
        while (map[p.x][p.y] > 1) {

            if (map[p.x - 1][p.y] < map[p.x][p.y] && map[p.x - 1][p.y] > 0) {
                p.x -= 1;
                road.add(new Point2D(p.x, p.y));
            }
            if (map[p.x][p.y - 1] < map[p.x][p.y] && map[p.x][p.y - 1] > 0) {
                p.y -= 1;
                road.add(new Point2D(p.x, p.y));
            }
            if (map[p.x + 1][p.y] < map[p.x][p.y] && map[p.x + 1][p.y] > 0) {
                p.x += 1;
                road.add(new Point2D(p.x, p.y));
            }
            if (map[p.x][p.y + 1] < map[p.x][p.y] && map[p.x][p.y + 1] > 0) {
                p.y += 1;
                road.add(new Point2D(p.x, p.y));
            }
        }
        return road;
    }

    //
    // Расстановка массива точек машрута на карте
    public void drawRoad(ArrayList<Point2D> rd) {
        for (int i = 0; i < rd.size(); i++) {
            map[rd.get(i).x][rd.get(i).y] = 0;
        }
    }
    //
}
