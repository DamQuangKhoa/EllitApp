package com.example.smith.ellit.util;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;

import com.example.smith.ellit.model.ContactDTO;

import java.util.ArrayList;
import java.util.List;


public class Util {
    private static final String TAG = "Util";
    public void getContactList(ContentResolver contentResolver) {
        ContentResolver cr = contentResolver;
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);
        if ((cur != null ? cur.getCount() : 0) > 0) {
            while (cur != null && cur.moveToNext()) {
                String id = cur.getString(
                        cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(
                        ContactsContract.Contacts.DISPLAY_NAME));

                if (cur.getInt(cur.getColumnIndex(
                        ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                    Cursor pCur = cr.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{id}, null);
                    while (pCur.moveToNext()) {
                        String phoneNo = pCur.getString(pCur.getColumnIndex(
                                ContactsContract.CommonDataKinds.Phone.NUMBER));
                        Log.i(TAG, "Name: " + name);
                        Log.i(TAG, "Phone Number: " + phoneNo);
                    }
                    pCur.close();
                }
            }
        }
        if(cur!=null){
            cur.close();
        }
    }

//    private List<ContactDTO> getAllContacts()
//    {
//        List<ContactDTO> ret = new ArrayList<ContactDTO>();
//
//        // Get all raw contacts id list.
//        List<Integer> rawContactsIdList = getRawContactsIdList();
//
//        int contactListSize = rawContactsIdList.size();
//
//        ContentResolver contentResolver = getContentResolver();
//
//        // Loop in the raw contacts list.
//        for(int i=0;i<contactListSize;i++)
//        {
//            // Get the raw contact id.
//            Integer rawContactId = rawContactsIdList.get(i);
//
//            Log.d(TAG_ANDROID_CONTACTS, "raw contact id : " + rawContactId.intValue());
//
//            // Data content uri (access data table. )
//            Uri dataContentUri = ContactsContract.Data.CONTENT_URI;
//
//            // Build query columns name array.
//            List<String> queryColumnList = new ArrayList<String>();
//
//            // ContactsContract.Data.CONTACT_ID = "contact_id";
//            queryColumnList.add(ContactsContract.Data.CONTACT_ID);
//
//            // ContactsContract.Data.MIMETYPE = "mimetype";
//            queryColumnList.add(ContactsContract.Data.MIMETYPE);
//
//            queryColumnList.add(ContactsContract.Data.DATA1);
//            queryColumnList.add(ContactsContract.Data.DATA2);
//            queryColumnList.add(ContactsContract.Data.DATA3);
//            queryColumnList.add(ContactsContract.Data.DATA4);
//            queryColumnList.add(ContactsContract.Data.DATA5);
//            queryColumnList.add(ContactsContract.Data.DATA6);
//            queryColumnList.add(ContactsContract.Data.DATA7);
//            queryColumnList.add(ContactsContract.Data.DATA8);
//            queryColumnList.add(ContactsContract.Data.DATA9);
//            queryColumnList.add(ContactsContract.Data.DATA10);
//            queryColumnList.add(ContactsContract.Data.DATA11);
//            queryColumnList.add(ContactsContract.Data.DATA12);
//            queryColumnList.add(ContactsContract.Data.DATA13);
//            queryColumnList.add(ContactsContract.Data.DATA14);
//            queryColumnList.add(ContactsContract.Data.DATA15);
//
//            // Translate column name list to array.
//            String queryColumnArr[] = queryColumnList.toArray(new String[queryColumnList.size()]);
//
//            // Build query condition string. Query rows by contact id.
//            StringBuffer whereClauseBuf = new StringBuffer();
//            whereClauseBuf.append(ContactsContract.Data.RAW_CONTACT_ID);
//            whereClauseBuf.append("=");
//            whereClauseBuf.append(rawContactId);
//
//            // Query data table and return related contact data.
//            Cursor cursor = contentResolver.query(dataContentUri, queryColumnArr, whereClauseBuf.toString(), null, null);
//
//            /* If this cursor return database table row data.
//               If do not check cursor.getCount() then it will throw error
//               android.database.CursorIndexOutOfBoundsException: Index 0 requested, with a size of 0.
//               */
//            if(cursor!=null && cursor.getCount() > 0)
//            {
//                StringBuffer lineBuf = new StringBuffer();
//                cursor.moveToFirst();
//
//                lineBuf.append("Raw Contact Id : ");
//                lineBuf.append(rawContactId);
//
//                long contactId = cursor.getLong(cursor.getColumnIndex(ContactsContract.Data.CONTACT_ID));
//                lineBuf.append(" , Contact Id : ");
//                lineBuf.append(contactId);
//
//                do{
//                    // First get mimetype column value.
//                    String mimeType = cursor.getString(cursor.getColumnIndex(ContactsContract.Data.MIMETYPE));
//                    lineBuf.append(" \r\n , MimeType : ");
//                    lineBuf.append(mimeType);
//
//                        List<String> dataValueList = getColumnValueByMimetype(cursor, mimeType);
//                    int dataValueListSize = dataValueList.size();
//                    for(int j=0;j < dataValueListSize;j++)
//                    {
//                        String dataValue = dataValueList.get(j);
//                        lineBuf.append(" , ");
//                        lineBuf.append(dataValue);
//                    }
//
//                }while(cursor.moveToNext());
//
//                Log.d(TAG_ANDROID_CONTACTS, lineBuf.toString());
//            }
//
//            Log.d(TAG_ANDROID_CONTACTS, "=========================================================================");
//        }
//
//        return ret;
//    }
}
