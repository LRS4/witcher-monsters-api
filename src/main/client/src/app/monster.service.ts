import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Monster } from './monster';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MonsterService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getMonsters(): Observable<Monster[]> {
    return this.http.get<Monster[]>(`${ this.apiServerUrl }/api/v1/monster`);
  }

  public addMonster(monster: Monster, categoryName: string): Observable<any> {
    return this.http.post<any>(
      `${ this.apiServerUrl }/api/v1/monster/category/${ categoryName }`,
      monster
    );
  }

  public updateMonster(monster: Monster, monsterId: number, categoryId: number): Observable<any> {
    return this.http.put<any>(
      `${ this.apiServerUrl }/api/v1/monster/${ monsterId }/${ categoryId }`,
      monster
    );
  }

  public deleteMonster(monsterId: number): Observable<any> {
    return this.http.delete<any>(`${ this.apiServerUrl }/api/v1/monster/${ monsterId }`);
  }
}
