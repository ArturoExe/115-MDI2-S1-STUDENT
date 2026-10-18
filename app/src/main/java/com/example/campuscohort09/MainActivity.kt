package com.example.campuscohort09

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import  androidx.compose.foundation.lazy.items


data class  CampusResource(
    @param:StringRes val namesRes: Int,
    @param:StringRes val category: Int,
    @param:StringRes val hoursRes: Int,
    val lastUpdate: String
)


val sampleResource = listOf(
    CampusResource(
        namesRes = R.string.resource_intl_office_name,
        category = R.string.resource_intl_office_category,
        hoursRes = R.string.resource_intl_office_hours,
        lastUpdate = "03/08/2026"
    ),
    CampusResource(
        namesRes = R.string.resource_library_name,
        category = R.string.resource_library_category,
        hoursRes = R.string.resource_library_hours,
        lastUpdate = "10/08/2026"
    ),
    CampusResource(
        namesRes = R.string.resource_veterans_name,
        category = R.string.resource_veterans_category,
        hoursRes = R.string.resource_veterans_hours,
        lastUpdate = "07/09/2026"
    )
)

class MainActivity: ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme{
                CampusConnectScreen()
            }
        }
    }
}
@Composable
fun CampusConnectScreen(){
    Column(modifier = Modifier.padding(all=16.dp)) {
        Text(stringResource(R.string.app_title), style = MaterialTheme.typography.headlineMedium)
        Text(stringResource(id = R.string.app_subtitle), style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier= Modifier.height(16.dp))

        LazyColumn {
            items(sampleResource){ resource ->
                ResourceCard(resource)
                Spacer(modifier = Modifier.height(12.dp))
            }
        }


    }
}



@Composable
fun ResourceCard(resource: CampusResource){
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier =Modifier.padding(12.dp) ){

            Text(
                stringResource(id=resource.namesRes),
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                stringResource(id=resource.category),
                style = MaterialTheme.typography.bodySmall
            )

            Text(
                stringResource(id=R.string.hours_label, stringResource(id = resource.hoursRes))
            )

            Text(
                stringResource(id=R.string.last_updated_label,resource.lastUpdate),
                style = MaterialTheme.typography.bodySmall)




        }
    }

}
